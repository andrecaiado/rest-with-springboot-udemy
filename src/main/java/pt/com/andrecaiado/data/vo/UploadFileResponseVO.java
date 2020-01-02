package pt.com.andrecaiado.data.vo;

import java.io.Serializable;

public class UploadFileResponseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String fileName;
	private String fileDownloadDir;
	private String fileType;
	private Long fileSize;
	
	public UploadFileResponseVO() {
	}
	
	public UploadFileResponseVO(String fileName, String fileDownloadDir, String fileType, Long fileSize) {
		this.fileName = fileName;
		this.fileDownloadDir = fileDownloadDir;
		this.fileType = fileType;
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDownloadDir() {
		return fileDownloadDir;
	}
	public void setFileDownloadDir(String fileDownloadDir) {
		this.fileDownloadDir = fileDownloadDir;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileDownloadDir == null) ? 0 : fileDownloadDir.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((fileSize == null) ? 0 : fileSize.hashCode());
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UploadFileResponseVO other = (UploadFileResponseVO) obj;
		if (fileDownloadDir == null) {
			if (other.fileDownloadDir != null)
				return false;
		} else if (!fileDownloadDir.equals(other.fileDownloadDir))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (fileSize == null) {
			if (other.fileSize != null)
				return false;
		} else if (!fileSize.equals(other.fileSize))
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		return true;
	}
	
}
