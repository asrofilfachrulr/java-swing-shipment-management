package Model;

public class City {
	private String name;
	private int id;
	private int metric;
	
	public City(String name, int id, int metric) {
		this.setId(id);
		this.setName(name);
		this.setMetric(metric);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMetric() {
		return metric;
	}

	public void setMetric(int metric) {
		this.metric = metric;
	}
	
	@Override
	public String toString() {
		return String.format("City[%d, %s, %d]", id, name, metric);
	}
}
