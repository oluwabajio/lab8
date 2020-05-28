package mazegame.boundary;

public interface IMazeClient {  // This interface is being implemented in SimpleconsoleClient.java
	public String getReply (String question);
	public void playerMessage (String message);
	public String getCommand();
}
