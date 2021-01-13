package cimpa.td.java;

public class Orange {
	public static final String NEGATIVEPRICE = "Negative price not allowed";

	private double prix;
	private String origine;

	public Orange(double prix, String origine) throws Exception {
		super();
		if (prix < 0)
			throw new UnsupportedOperationException(NEGATIVEPRICE);
		this.prix = prix;
		this.origine = origine;
	}

	public double getPrix() {
		return prix;
	}

	public String getOrigine() {
		return origine;
	}

	@Override
	public String toString() {
		return "Orange [prix=" + prix + ", origine=" + origine + "]\r";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((origine == null) ? 0 : origine.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Orange other = (Orange) obj;
		if (origine == null) {
			if (other.origine != null)
				return false;
		} else if (!origine.equals(other.origine))
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
	}

}
