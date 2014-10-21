package com.ma.ouyuu.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class PathInfo implements Parcelable {

	/**
	 * serialVersionUID:TODO
	 * 
	 * @since Ver 1.1
	 * 
	 *        另外一种序列化方法 1.实现Serializable接口即可 2.实现Parcelable接口
	 * 
	 * @Override public int describeContents() { return 0; }
	 * @Override public void writeToParcel(Parcel dest, int flags) {
	 *           dest.writeString(startPlace); dest.writeString(startTime);
	 *           dest.writeString(travelWay); }
	 * 
	 *           public static final Parcelable.Creator<PathInfo>CREATOR = new
	 *           Creator<PathInfo>() {
	 * @Override public PathInfo createFromParcel(Parcel source) { PathInfo
	 *           pathInfo = new PathInfo(); pathInfo.startPlace =
	 *           source.readString(); pathInfo.startTime = source.readString();
	 *           pathInfo.travelWay = source.readString(); return pathInfo; }
	 * @Override public PathInfo[] newArray(int size) { return new
	 *           PathInfo[size]; } };
	 * 
	 */

	private String pathId;
	private String startPlace;
	private String endPlace;
	private String startTime;
	private String travelWay;

	public String getPathId() {
		return pathId;
	}

	public void setPathId(String pathId) {
		this.pathId = pathId;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getTravelWay() {
		return travelWay;
	}

	public void setTravelWay(String travelWay) {
		this.travelWay = travelWay;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(pathId);
		dest.writeString(startPlace);
		dest.writeString(endPlace);
		dest.writeString(startTime);
		dest.writeString(travelWay);
	}

	public static final Parcelable.Creator<PathInfo> CREATOR = new Creator<PathInfo>() {

		@Override
		public PathInfo createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			PathInfo pathInfo = new PathInfo();
			pathInfo.pathId = source.readString();
			pathInfo.startPlace = source.readString();
			pathInfo.endPlace = source.readString();
			pathInfo.startTime = source.readString();
			pathInfo.travelWay = source.readString();
			return pathInfo;
		}

		@Override
		public PathInfo[] newArray(int size) {
			// TODO Auto-generated method stub
			return new PathInfo[size];
		}
	};
}
