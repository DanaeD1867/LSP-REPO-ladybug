package src.org.howard.edu.lsp.midterm.question4;

/**
 * Represents a Smart Thermostat
 * 
 * Implementation of a smart thermostat through the use of the device abstract class and the networked and batterypowered interfaces. 
 */
public class Thermostat extends Device implements Networked{
    private double temperatureC; 

    public Thermostat(String id, String location, double initialTempC){
        super(id, location);
        this.temperatureC = initialTempC;
    }

    //Accessors
    public double getTemperatureC(){ return this.temperatureC;};
    public void setTemperatureC(double temperatureC){this.temperatureC = temperatureC;};

    // Networked
    @Override public void connect()    { setConnected(true);  }
    @Override public void disconnect() { setConnected(false); }
    @Override public boolean isConnected() { return super.isConnected(); }

    // Status
    @Override public String getStatus() {
    String connStatus = isConnected() ? "up" : "down";
    return "Thermostat[id=" + getId() + ", loc=" + getLocation() +
            ", conn=" + connStatus + ", tempC=" + temperatureC + "]";
    }


}
