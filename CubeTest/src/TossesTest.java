import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.System.*;
import java.util.Scanner;

public class TossesTest {
    public static int[] GetCubeTosses( NumberCube cube, int numTosses ) {
        int[] allTosses = new int[ numTosses ];

        for ( int i = 0; i < numTosses; i++ )
            allTosses[i] = cube.Toss();

        return allTosses;
    }

    public static void printIndices( int numTosses ) {
        out.print( " " + 0 + "  " );
        for ( int i = 1; i < numTosses; i++ ) {
            if ( i < 10 )
                out.print( i + "  " );
            else
                out.print( i + " " );
        }
    }

    public static ArrayList<Integer> GetLongestRun(int[] values ) {
        ArrayList<Integer> allLongRuns = new ArrayList<Integer>();
        ArrayList<Integer> allLongRunsIndices = new ArrayList<Integer>();
        int longestIndex = 0;
        int longestNum = 0;
        int length = 0;
        int longerNum = 0;
        int longerIndex = 0;
        for ( int i = 0; i < values.length; i++ ) {
            if ( values[ i ] == longestNum ) {
                //if number is equal to previous number, length ++
                length++;
            }
            else {
                //if length is bigger than or equal to 2, then the loop will break.
                if ( length >= longerNum && length > 1 ) {
                    longerNum = length;
                    longestIndex = i - length;
                    longerIndex = longestIndex;
                    allLongRuns.add( longerNum );
                    allLongRunsIndices.add( longerIndex );
                }
                //if num is not equal, longest index is set to i, length is set to 1,
                // and longestNum is set to the unequal value to prepare for the next iteration
                longestNum = values[ i ];
                longestIndex = i;
                length = 1;
            }
        }

        if ( length > longerNum ) {
            longerNum = length;
        }

        int tempLength = 0;
        ArrayList<Integer> indices = new ArrayList<Integer>();
        for ( int i = 0; i < allLongRuns.size(); i++ ) {
            if ( allLongRuns.get( i ) > tempLength ) {
                tempLength = allLongRuns.get( i );
            }
        }

        for ( int i = 0; i < allLongRunsIndices.size(); i++ ) {
            if ( allLongRuns.get( i ) == tempLength ) {
                indices.add( allLongRunsIndices.get( i ) );
            }
        }

        if ( longerNum <= 1 ) {
            allLongRuns.add( -1 );
            return allLongRuns;
        }
        else
            return indices;
    }

    public static void main( String[] args ) {
        Scanner stdin = new Scanner( in );
        out.print( "How many times do you want to roll the dice?: " );

        while ( stdin.hasNext() ) {
            int rollNumber = stdin.nextInt();

            NumberCube cube = new NumberCube();

            int[] allTosses = GetCubeTosses( cube, rollNumber );
            out.println( "The rolls are: " + Arrays.toString( allTosses ) );

            ArrayList<Integer> allLongRuns = GetLongestRun( allTosses );
            out.println( "\nThe first longest run of die that occured is at indices " + allLongRuns );

            out.print( "How many times do you want to roll the dice?: " );

        }
    }
}
