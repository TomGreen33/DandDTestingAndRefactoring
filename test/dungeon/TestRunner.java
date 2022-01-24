package dungeon;

import java.util.List;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String [] args) {

        System.out.println("\n--------------- Chamber Test ---------------\n");
		Result chamberResult = JUnitCore.runClasses(ChamberTest.class);

        System.out.println("\nFailed Test Report:\n");
        List<Failure> chamberFailedList = chamberResult.getFailures();
        chamberFailedList.forEach(f -> {
            System.out.println(f);
        });
        System.out.println("\nNumber of Failed Tests = " + chamberResult.getFailureCount());


		System.out.println("\n---------------- Door  Test ----------------\n");
		Result doorResult = JUnitCore.runClasses(DoorTest.class);
        System.out.println("\nFailed Test Report:\n");
        List<Failure> doorFailedList = doorResult.getFailures();
        doorFailedList.forEach(f -> {
            System.out.println(f);
        });
        System.out.println("\nNumber of Failed Tests = " + doorResult.getFailureCount());


		System.out.println("\n--------------- Passage Test ---------------\n");
		Result passageResult = JUnitCore.runClasses(PassageTest.class);
        System.out.println("\nFailed Test Report:\n");
        List<Failure> passageFailedList = passageResult.getFailures();
        passageFailedList.forEach(f -> {
            System.out.println(f);
        });
        System.out.println("\nNumber of Failed Tests = " + passageResult.getFailureCount());


		System.out.println("\n----------- PassageSection  Test -----------\n");
		Result passageSectionResult = JUnitCore.runClasses(PassageSectionTest.class);
        System.out.println("\nFailed Test Report:\n");
        List<Failure> passageSectionFailedList = passageSectionResult.getFailures();
        passageSectionFailedList.forEach(f -> {
            System.out.println(f);
        });
        System.out.println("\nNumber of Failed Tests = " + passageSectionResult.getFailureCount());

        /*repeat steps the above for each junit test file you have*/
	}
}
