package src.org.howard.edu.lsp.midterm.question4;

/*
 * Represents the networked capabilities of the devices.
 */
public interface Networked {
    //Brings device online (sets connected = true)
    void connect(); 
    //Brings device offlice (sets connected = false)
    void disconnect();
    //Reports the current connection state
    boolean isConnected(); 
}
