
public class Customer {
	private String name;
	private long idNr;
	private long bnkNr;
	private static long bnkNrGenerator = 1;

	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		bnkNr = bnkNrGenerator;
		bnkNrGenerator++;
	}

	public String getName() {
		return name;
	}
	
	public long getIdNr() {
		return idNr;
	}

	public long getBnkNr() {
		return bnkNr;
	}

	public String toString() {
		return "  (" + name + ", id " + idNr + ", kundnr " + bnkNr + "): ";
	}
}
