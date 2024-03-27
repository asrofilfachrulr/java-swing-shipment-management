package Model;

public class City {
	private String name;
	private int id;
	private int metric;
	private String nameAbbr;

	public City(String name, int id, int metric, String nameAbbr) {
		this.setId(id);
		this.setName(name);
		this.setMetric(metric);
		this.setNameAbbr(nameAbbr);
	}

	public String getNameAbbr() {
		return nameAbbr;
	}

	public void setNameAbbr(String nameAbbr) {
		this.nameAbbr = nameAbbr;
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
