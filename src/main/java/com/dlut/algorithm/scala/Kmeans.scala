package com.dlut.algorithm.scala

import scala.collection.mutable
import scala.io.Source
import scala.util.Random

object Kmeans {
  val k = 2 //类个数
  val dim = 3 //数据集维度
  val shold = 0.0000000001 //阈值，用于判断聚类中心偏移量
  val centers = new Array[Vector[Double]](k) //聚类中心点（迭代更新）

  def main(args: Array[String]): Unit = {
    //处理输入数据
    val fileName = "D:\\kmeans_data.txt"
    val lines = Source.fromFile(fileName).getLines()
    val points = lines.map(line => { //数据预处理
      val parts = line.split(" ").map(_.toDouble)
      var vector = Vector[Double]()
      for (i <- 0 until dim)
        vector ++= Vector(parts(i))
      vector
    }).toArray
    initialCenters(points)
    kmeans(points, centers)
    printResult(points, centers)

  }

  //-------------------------------------随机初始化聚类中心---------------------------------------------------
  def initialCenters(points: Array[Vector[Double]]): Unit = {
    val pointsNum = points.length //数据集个数
    //寻找k个随机数(作为数据集的下标)
    val random = new Random()
    var index = 0
    var flag = true
    var temp = 0
    var array = new mutable.LinkedList[Int]() //保存随机下标号
    while (index < k) {
      temp = new Random().nextInt(pointsNum)
      flag = true
      if (array.contains(temp)) { //在数组中存在
        flag = false
      }
      else {
        if (flag) {
          array = array :+ temp
          index += 1
        }
      } //else-end
    } //while-end
    for (i <- 0 to centers.length - 1) {
      centers(i) = points(array(i))
      println("初始化中心点如下：")
      println(array(i))
      println(centers(i))
    }
  }

  //---------------------------迭代做聚类-------------------------------------
  def kmeans(points: Array[Vector[Double]], centers: Array[Vector[Double]]) = {
    var bool = true
    var newCenters = Array[Vector[Double]]()
    var move = 0.0
    var currentCost = 0.0 //当前的代价函数值
    var newCost = 0.0
    //根据每个样本点最近的聚类中心进行groupBy分组，最后得到的cluster是Map[Vector[Double],Array[Vector[Double]]]
    //Map中的key就是聚类中心，value就是依赖于该聚类中心的点集
    while (bool) { //迭代更新聚类中心，直到最优
      move = 0.0
      currentCost = computeCost(points, centers)
      val cluster = points.groupBy(v => closestCenter(centers, v))
      newCenters =
        centers.map(oldCenter => {
          cluster.get(oldCenter) match { //找到该聚类中心所拥有的点集
            case Some(pointsInThisCluster) =>
              //均值作为新的聚类中心
              vectorDivide(pointsInThisCluster.reduceLeft((v1, v2) => vectorAdd(v1, v2)), pointsInThisCluster.length)
            case None => oldCenter
          }
        })
      for (i <- 0 to centers.length - 1) {
        //move += math.sqrt(vectorDis(newCenters(i),centers(i)))
        centers(i) = newCenters(i)
      }
      /* if(move <= shold){
         bool = false
       }*/
      newCost = computeCost(points, centers) //新的代价函数值
      println("当前代价函数值：" + currentCost)
      println("新的代价函数值：" + newCost)
      if (math.sqrt(vectorDis(Vector(currentCost), Vector(newCost))) < shold)
        bool = false
    } //while-end
    println("寻找到的最优中心点如下：")
    for (i <- 0 to centers.length - 1) {
      println(centers(i))
    }
  }

  //--------------------------输出聚类结果-----------------------------
  def printResult(points: Array[Vector[Double]], centers: Array[Vector[Double]]) = {
    //将每个点的聚类中心用centers中的下标表示，属于同一类的点拥有相同的下标
    val pointsNum = points.length
    val pointsLabel = new Array[Int](pointsNum)
    var closetCenter = Vector[Double]()
    println("聚类结果如下：")
    for (i <- 0 to pointsNum - 1) {
      closetCenter = centers.reduceLeft((c1, c2) => if (vectorDis(c1, points(i)) < vectorDis(c2, points(i))) c1 else c2)
      pointsLabel(i) = centers.indexOf(closetCenter)
      println(points(i) + "-----------" + pointsLabel(i))
    }

  }

  //--------------------------找到某样本点所属的聚类中心-----------------------------
  def closestCenter(centers: Array[Vector[Double]], v: Vector[Double]): Vector[Double] = {
    centers.reduceLeft((c1, c2) =>
      if (vectorDis(c1, v) < vectorDis(c2, v)) c1 else c2
    )
  }

  //--------------------------计算代价函数（每个样本点到聚类中心的距离之和不再有很大变化）-----------------------------
  def computeCost(points: Array[Vector[Double]], centers: Array[Vector[Double]]): Double = {
    //cluster:Map[Vector[Double],Array[Vector[Double]]
    val cluster = points.groupBy(v => closestCenter(centers, v))
    var costSum = 0.0
    //var subSets = Array[Vector[Double]]()
    for (i <- 0 to centers.length - 1) {
      cluster.get(centers(i)) match {
        case Some(subSets) =>
          for (j <- 0 to subSets.length - 1) {
            costSum += (vectorDis(centers(i), subSets(j)) * vectorDis(centers(i), subSets(j)))
          }
        case None => costSum = costSum
      }
    }
    costSum
  }

  //--------------------------自定义向量间的运算-----------------------------
  //--------------------------向量间的欧式距离-----------------------------
  def vectorDis(v1: Vector[Double], v2: Vector[Double]): Double = {
    var distance = 0.0
    for (i <- 0 to v1.length - 1) {
      distance += (v1(i) - v2(i)) * (v1(i) - v2(i))
    }
    distance = math.sqrt(distance)
    distance
  }

  //--------------------------向量加法-----------------------------
  def vectorAdd(v1: Vector[Double], v2: Vector[Double]): Vector[Double] = {
    var v3 = v1
    for (i <- 0 to v1.length - 1) {
      v3 = v3.updated(i, v1(i) + v2(i))
    }
    v3
  }

  //--------------------------向量除法-----------------------------
  def vectorDivide(v: Vector[Double], num: Int): Vector[Double] = {
    var r = v
    for (i <- 0 to v.length - 1) {
      r = r.updated(i, r(i) / num)
    }
    r
  }
}
