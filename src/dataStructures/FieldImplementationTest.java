package dataStructures;

import dataStructures.fieldImplementation.FieldStructure;
import dataStructures.linkedListImplementation.LinkedList;

public class FieldImplementationTest extends ImplementationTest{
	
	@Override
	public boolean testInsert(boolean print) {
		
		FieldStructure testObject = createFieldTestObject(1, 0);
		
		if(testObject.getElements().length == 1 && testObject.getElements()[0] == null) {
			
			testObject.insert(new User());
			
			if(testObject.getElements().length == 1  && testObject.getElements()[0] != null) {
				
				if(print) {
					System.out.println("insert test passed.");
				}
				
				return true;
				
			}
			
			if(print) {
				System.out.println("insert test failed.");
			}
			
			return false;
			
		}
		if(print) {
			System.out.println("unexpected error in insert test... Test Failed :(");
		}
		return false;
		
		
	}
	
	@Override
	public boolean testRemove(boolean print) {
		
		FieldStructure testObject = createFieldTestObject(1, 1);
		
		if(testObject.getElements().length == 1 && testObject.getElements()[0] != null) {
			
			testObject.remove();
			
			if(testObject.getElements().length == 1 && testObject.getElements()[0] == null) {
				
				if(print) {
					System.out.println("remove test passed.");
				}
				
				return true;
				
			}
			
			if(print) {
				System.out.println("remove test failed.");
			}
			
			return false;
			
		}
		
		if(print) {
			System.out.println("unexpected error in remove test... Test Failed :(");
		}
		return false;
		
	}
	
	@Override
	public boolean testIsEmpty(boolean print) {
		
		FieldStructure testObject = createFieldTestObject(2, 0);
		
		if(testObject.isEmpty()) {
			
			testObject.insert(new User());
			if(!testObject.isEmpty()) {
				
				if(print) {
					System.out.println("isEmpty test passed.");
				}
				
				return true;
				
			}
			
			if(print) {
				System.out.println("test failed.");
			}
			
			return false;
		}
		
		if(print) {
			System.out.println("unexpected error in isEmptyTest... Test Failed :(");
		}
		
		return false;
	}
	
	@Override
	public boolean testInsertOrder(boolean print) {
		
		FieldStructure testObject = createFieldTestObject(2, 0);
		
		User testData1 = new User();
		User testData2 = new User();
		
		testObject.insert(testData1);
		testObject.insert(testData2);
		
		testObject.insert(testData2);
		
		DataElement[] elements = testObject.getElements();
		
		if(elements[0] == testData1 && elements[1] == testData2) {
			
			if(print) {
				System.out.println("insert order test passed.");	
			}
			return true;
			
		}
		
		if(print) {
			System.out.println("insert order test failed.");		
		}
		return false;
		
	}
	
	@Override
	public boolean testRemoveOrder(boolean print) {
		
		FieldStructure testObject = createFieldTestObject(2, 1);

		User testData = new User();
		testObject.insert(testData);
		
		testObject.remove();
		
		DataElement[] elements = testObject.getElements();
		
		if(elements[0] == testData && elements[1] == null) {
			
			if(print) {
				System.out.println("remove order test passed.");
			}
			return true;
			
		}
		
		if(print) {
			System.out.println("remove order test failed.");
		}
		return false;
		
	}
	
	@Override
	public boolean testGetNElements(boolean print) {
		
		FieldStructure testObject = createFieldTestObject(2, 0);
		boolean testPassed = true;
		
		User testData = new User();
		
		testPassed = (testObject.getNElements() == 0);
		
		fillTestObject(testObject, 2);
		testPassed = testPassed && (testObject.getNElements() == 2);
		
		testObject.insert(testData);
		testPassed = testPassed && (testObject.getNElements() == 2);
		
		testObject.remove();
		testPassed = testPassed && (testObject.getNElements() == 1);
		
		if(testPassed) {
			
			if(print) {
				System.out.println("getNElements test passed.");
			}
			
			return true;
			
		}
		
		if(print) {
			System.out.println("getNElements test failed.");
		}
		
		return false;
		
	}
	
	@Override
	public void testPrintAll() {
		
		FieldStructure testObject = createFieldTestObject(5, 5);
		
		testObject.printAll();
		
	}
	
	private ListImplementation[] createTestObjects(boolean field, boolean linkedList, int listSize, int nTestElements) {
		
		ListImplementation[] testObjects = null;
		
		if(field && linkedList) {
			testObjects = new ListImplementation[2];
			testObjects[0] = createTestLinkedListObject(nTestElements);
			testObjects[1] = createFieldTestObject(listSize, nTestElements);
		}else if(field ^ linkedList) {
			testObjects = new ListImplementation[1];
			if(field) testObjects[0] = createFieldTestObject(listSize, nTestElements);
			else if(linkedList) testObjects[0] = createTestLinkedListObject(nTestElements); 
		}else {
			testObjects = new ListImplementation[0];
		}
		
		return testObjects;
		
	}
	
	private FieldStructure createFieldTestObject(int listSize, int nTestElements) {
		
		FieldStructure testObject = new FieldStructure(listSize);
		fillTestObject(testObject, nTestElements);
		
		return testObject;
		
	}
	
	private void fillTestObject(FieldStructure testObject, int nTestElements) {
		
		DataElement[] testElements =  createTestData(nTestElements);
		
		for(DataElement testElement: testElements) {
			
			testObject.insert(testElement);
			
		}
		
	}
	
	private User[] createTestData(int nTestElements) {
		
		User[] testElements = new User[nTestElements];
		
		for(int i = 0; i < nTestElements; i++) {
			
			testElements[i] = new User();
			
		}
		
		return testElements;
		
	}
	
private LinkedList createTestLinkedListObject(int nTestElements) {
		
		LinkedList testObject = new LinkedList();
		
		if(nTestElements > 0) {
			addTestDataLinkedListElements(testObject, nTestElements);
		}
		
		return testObject;
		
	}
	
	private void addTestDataLinkedListElements(LinkedList testObject, int nTestElements) {
		
		for(int i = 0; i < nTestElements; i++) {
			testObject.insert(new User());
		}
		
	}
	

}
