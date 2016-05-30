package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Convertor.Convertor;
import src.Instruction;

public class TestAssignmentInstruction {

	@Test
	public void test() {
		Instruction instruction = new Instruction("glob is I");
		Convertor convertor = new Convertor();
		instruction.run(convertor);
		
		assertEquals(1, convertor.value("glob"));
	}
	@Test
	public void test1() {
		Instruction instruction = new Instruction("how much is glob ?");
		Convertor convertor = new Convertor();
		StringBuilder sb = new StringBuilder();
		//instruction.run(convertor, sb);
		
		//assertEquals(1, "glob is 1");
	}

}
