package FlatMap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Film {
	//电影
	private String name;
	private BigDecimal boxOffice;//票房
	private List<Actor> actors = new ArrayList<Actor>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getBoxOffice() {
		return boxOffice;
	}
	public void setBoxOffice(BigDecimal boxOffice) {
		this.boxOffice = boxOffice;
	}
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	@Override
	public String toString() {
		return "Film [name=" + name + ", boxOffice=" + boxOffice + ", getName()=" + getName() + ", getBoxOffice()="
				+ getBoxOffice() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	

}
