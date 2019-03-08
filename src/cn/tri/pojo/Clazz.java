package cn.tri.pojo;

public class Clazz {
	private int ClassId;
	private int name;
	public int getClassId() {
		return ClassId;
	}
	public void setClassId(int classId) {
		ClassId = classId;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public Clazz(int classId, int name) {
		super();
		ClassId = classId;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Clazz [ClassId=" + ClassId + ", name=" + name + "]";
	}
	
	
}
