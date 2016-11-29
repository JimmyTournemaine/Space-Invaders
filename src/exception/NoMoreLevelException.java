package exception;

public class NoMoreLevelException extends RuntimeException {

	private static final long serialVersionUID = 2029338471666119104L;

	public NoMoreLevelException()
	{
		super("Congratulations ! There is no more level.");
	}
}
