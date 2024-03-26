package com.dlut.pojo;

public class File {
    private Integer fileId;

    private String fileName;

    private Integer fileType;

    private String fileDiscribe;

    private String fileDirectory;

    private String fileCompletePath;

    private String fileRelativePath;

    private String fileAuthor;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getFileDiscribe() {
        return fileDiscribe;
    }

    public void setFileDiscribe(String fileDiscribe) {
        this.fileDiscribe = fileDiscribe == null ? null : fileDiscribe.trim();
    }

    public String getFileDirectory() {
        return fileDirectory;
    }

    public void setFileDirectory(String fileDirectory) {
        this.fileDirectory = fileDirectory == null ? null : fileDirectory.trim();
    }

    public String getFileCompletePath() {
        return fileCompletePath;
    }

    public void setFileCompletePath(String fileCompletePath) {
        this.fileCompletePath = fileCompletePath == null ? null : fileCompletePath.trim();
    }

    public String getFileRelativePath() {
        return fileRelativePath;
    }

    public void setFileRelativePath(String fileRelativePath) {
        this.fileRelativePath = fileRelativePath == null ? null : fileRelativePath.trim();
    }

    public String getFileAuthor() {
        return fileAuthor;
    }

    public void setFileAuthor(String fileAuthor) {
        this.fileAuthor = fileAuthor == null ? null : fileAuthor.trim();
    }
}