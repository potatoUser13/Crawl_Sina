package bean;

public class Event {
	public int id;
	public String name;
	public String hot;
	public String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHot() {
		return hot;
	}
	public void setHot(String hot) {
		this.hot = hot;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", hot=" + hot + ", url=" + url + "]";
	}

}
