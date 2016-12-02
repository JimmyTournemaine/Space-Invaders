/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package exception;

/**
 * Throws when there is no more available levels
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class NoMoreLevelException extends RuntimeException {

	private static final long serialVersionUID = 2029338471666119104L;

	public NoMoreLevelException()
	{
		super("Congratulations ! There is no more level.");
	}
}
