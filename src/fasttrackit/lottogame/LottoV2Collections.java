package fasttrackit.lottogame;

/**
 * Created by condor on 30/11/15.
 */

import java.util.*;

public class LottoV2Collections {

    private static final int MAXVALUE = 49;
    private static final int MAX_EXTRACTION_NUMBERS = 6;

    public static void main(String args[]) {
        List<Integer> lottoList = new ArrayList<>();
        for (int i = 1; i <= MAXVALUE; i++) {
            lottoList.add(i);
        }
        System.out.println("Initial collection: " + lottoList);

        // shuffle the list
        Collections.shuffle(lottoList);

        //extract those MAX_EXTRACTION_NUMBERS numbers
        List<Integer> lottoExtractedNumbersSet = new ArrayList<>();
        for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++) {
            lottoExtractedNumbersSet.add(lottoList.get(i));
        }

        // print the extraction
        System.out.println("Final set after shuffle: " + lottoExtractedNumbersSet);


        // myTicket
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());

        boolean isWinner = false;
        long counter = 0;
        Set<Integer> myTicket;
        do {
            myTicket = extractSixUniqueNumbers(r);
            counter++;
            if (myTicket.containsAll(lottoExtractedNumbersSet)) {
                isWinner = true;
            }
            if (counter % 10000000 == 0)
                System.out.println("tickets:" + counter);
        }
        while (!isWinner);

        System.out.println("winner after:" + counter);
        System.out.println("winning ticket:" + myTicket);
    }


    private static Set<Integer> extractSixUniqueNumbers(Random lottoMachine) {
        Set<Integer> sixGeneratedNumbers = new HashSet<>();
        int nr;
        //    int dupl=0;
        do {
            nr = lottoMachine.nextInt(MAXVALUE) + 1;
            sixGeneratedNumbers.add(nr);
//           dupl++;
//           if(dupl>MAX_EXTRACTION_NUMBERS)
//               System.out.println("dupl"+dupl);
        }
        while (sixGeneratedNumbers.size() != MAX_EXTRACTION_NUMBERS);
        return sixGeneratedNumbers;

    }

}