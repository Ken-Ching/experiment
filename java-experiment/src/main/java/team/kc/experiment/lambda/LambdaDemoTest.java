package team.kc.experiment.lambda;

import java.util.Arrays;

public class LambdaDemoTest {
	
	public static void testForEach () {
		Arrays.asList( "a", "b", "d" ).forEach( e -> System.out.println( e ) );
		
		Arrays.asList( 1, 2, 3 ).forEach( e -> {
			System.out.print( e + ":" );
			System.out.println( e+e );
		} );
	}

	public static void main (String[] arts) {
		testForEach();
	}
	
}
