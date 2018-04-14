public class Chain_AL extends java.util.ArrayList{
	public String toString() {
		String output = "";
		for (int i = 0; i < this.size(); i++) {
			AminoAcid current = (AminoAcid) this.get(i);
			output += current.full_name;
			output += "\n";
		}
		return output;
	}
}
