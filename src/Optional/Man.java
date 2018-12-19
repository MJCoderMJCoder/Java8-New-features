package Optional;

import java.util.Optional;

public class Man {
	private Optional<Godness> godness = Optional.empty();

	public Optional<Godness> getGodness() {
		return godness;
	}

	public void setGodness(Optional<Godness> godness) {
		this.godness = godness;
	}

	@Override
	public String toString() {
		return "Man [godness=" + godness + "]";
	}

	public Man(Optional<Godness> godness) {
		super();
		this.godness = godness;
	}

	public Man() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	
	

}
