<html>
	<head>
		<meta charset=utf-8 />
		<title>Simple DynamicMapLayer</title>
		<meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' />

		<!-- Load Leaflet from CDN -->
		<link rel="stylesheet" href="https://unpkg.com/leaflet@1.4.0/dist/leaflet.css" integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA=="
		 crossorigin="" />
		<script src="https://unpkg.com/leaflet@1.4.0/dist/leaflet.js" integrity="sha512-QVftwZFqvtRNi0ZyCtsznlKSWOStnDORoefr1enyq5mVL4tmKB3S/EnC3rRJcxCPavG10IcrVGSmPh6Qw5lwrg=="
		 crossorigin=""></script>


		<!-- Load Esri Leaflet from CDN -->
		<script src="https://unpkg.com/esri-leaflet@2.2.4/dist/esri-leaflet.js" integrity="sha512-tyPum7h2h36X52O2gz+Pe8z/3l+Y9S1yEUscbVs5r5aEY5dFmP1WWRY/WLLElnFHa+k1JBQZSCDGwEAnm2IxAQ=="
		 crossorigin=""></script>

		<link rel="stylesheet" href="https://unpkg.com/esri-leaflet-geocoder@2.2.14/dist/esri-leaflet-geocoder.css"
			integrity="sha512-v5YmWLm8KqAAmg5808pETiccEohtt8rPVMGQ1jA6jqkWVydV5Cuz3nJ9fQ7ittSxvuqsvI9RSGfVoKPaAJZ/AQ=="
			crossorigin="">
		<script src="https://unpkg.com/esri-leaflet-geocoder@2.2.14/dist/esri-leaflet-geocoder.js"
			integrity="sha512-uK5jVwR81KVTGe8KpJa1QIN4n60TsSV8+DPbL5wWlYQvb0/nYNgSOg9dZG6ViQhwx/gaMszuWllTemL+K+IXjg=="
			crossorigin=""></script>
		<style>
			body {
				margin: 0;
				padding: 0;
			}

			#map {
				position: absolute;
				top: 0;
				bottom: 0;
				right: 0;
				left: 0;
			}
		</style>
	</head>
	<body>

		<div id="map"></div>

		<script>
			var map = L.map('map', {
				minZoom: 0,
				maxZoom: 14
			});
			map.setView([39.467098, 117.004395], 12);
			// map.setView([117.014, 39.495], 10);
			map.setZoom(12);
			// var map = L.map('map').setView([117.014,39.495],2);
			// 			var map = L.map('map').setView([37.71, -99.88], 4);
			// 			L.esri.basemapLayer('Gray').addTo(map);

			L.esri.dynamicMapLayer({
				// url: 'https://services.arcgisonline.com/arcgis/rest/services/Specialty/Soil_Survey_Map/MapServer',
				url: 'http://localhost:6080/arcgis/rest/services/wuqingxzq/MapServer',
				searchFields : ['NAME_3','NAME_1'],

				opacity: 0.7
			}).addTo(map);
			var mypop = L.popup();

			var searchControl = L.esri.Geocoding.geosearch({
				providers: [
				  <!-- arcgisOnline, -->
				  L.esri.Geocoding.mapServiceProvider({
					label: 'States and Counties',
					url: 'http://localhost:6080/arcgis/rest/services/wuqingxzq/MapServer',
					layers: [1],
					searchFields: ['NAME_1', 'NAME_3']
				  })
				]
			  }).addTo(map);

			var greenIcon = L.icon({
				iconUrl: 'http://localhost:8080/arcgis_js_api/green.png',

				iconSize:     [15, 15], // size of the icon
				popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
			});
			var redIcon = L.icon({
				iconUrl: 'http://localhost:8080/arcgis_js_api/red.png',

				iconSize:     [15, 15], // size of the icon
				popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
			});
			var orangeIcon = L.icon({
				iconUrl: 'http://localhost:8080/arcgis_js_api/orange.png',

				iconSize:     [15, 15], // size of the icon
				popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
			});
			var yellowIcon = L.icon({
				iconUrl: 'http://localhost:8080/arcgis_js_api/yellow.png',

				iconSize:     [15, 15], // size of the icon
				popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
			});
			var options = {
				minWidth : 250
			};
			
			<!--red-->
			L.marker([39.445842, 117.184682], {icon: redIcon}).addTo(map)
			.bindPopup('<table><tr><td>镉含量（mg）:</td><td>0.08mg</td></tr><tr><td>国家标准（mg）</td><td>0.05mg</td></tr><tr><td>比值</td><td>150%</td></tr><tr><td>经度</td><td>117.184682</td></tr><tr><td>纬度:</td><td>39.445842</td></tr></table>',options);
			
			<!-- green -->
			L.marker([39.345528, 117.113235], {icon: greenIcon}).addTo(map)
			.bindPopup('<table><tr><td>镉含量（mg）:</td><td>0.03mg</td></tr><tr><td>国家标准（mg）</td><td>0.05mg</td></tr><tr><td>比值</td><td>60%</td></tr><tr><td>经度</td><td>117.017492</td></tr><tr><td>纬度:</td><td>39.345528</td></tr></table>',options);
			L.marker([39.333158, 117.017492], {icon: greenIcon}).addTo(map)
			.bindPopup('<table><tr><td>镉含量（mg）:</td><td>0.24mg</td></tr><tr><td>国家标准（mg）</td><td>0.05mg</td></tr><tr><td>比值</td><td>48%</td></tr><tr><td>经度</td><td>117.283492</td></tr><tr><td>纬度:</td><td>39.333158</td></tr></table>',options);

			
		</script>

	</body>
</html>
