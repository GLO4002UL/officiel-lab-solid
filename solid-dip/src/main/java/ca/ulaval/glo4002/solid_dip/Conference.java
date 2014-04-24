package ca.ulaval.glo4002.solid_dip;

// This is a DTO for the purposes of this example, 
// but it should be a domain object.
public class Conference {

	public String name;
	public String description;
	
	public boolean Equals(Object o) {
		if(!(o instanceof Conference)) {
			return false;
		}
		
		Conference other = (Conference) o;
		return this.name.equals(other.name);
	}
	
	public int hashCode() {
		return this.name.hashCode();
	}
}
