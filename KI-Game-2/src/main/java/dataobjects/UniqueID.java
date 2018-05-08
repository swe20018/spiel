package dataobjects;

public abstract class UniqueID {

	private String id;
	
	protected UniqueID(String id)
	{
		this.id = id;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
