package LAB;

class CountryNotValidException extends Exception{
	public CountryNotValidException(String msg) {
		super(msg);
	}}

class EmployeeNameInvalidException extends Exception{
	public EmployeeNameInvalidException(String msg) {
		super(msg);
	}}

class TaxNotEligibleException extends Exception{
	public TaxNotEligibleException(String msg) {
		super(msg);
	}}

 class TaxCalculator {
	public void calculateTax(String empName,boolean isIndian,double empSal)throws Exception{
	if(isIndian==false) {
		try {
			throw new  CountryNotValidException("The employee should be an Indian citizen for calculating tax");
			}
		catch(CountryNotValidException e) 
		{
			System.out.println(e.getMessage());
			
		}}
	else if(empName==null)
	{
		try {
			throw new  EmployeeNameInvalidException("The employee name can not be empty");
             }
		catch(EmployeeNameInvalidException e) {
			System.out.println(e.getMessage());
			
		}}
	else if(empSal>100000 && isIndian==true) {
		System.out.println(empSal *8/100 );
	}	else if(empSal>50000 && empSal<100000 && isIndian==true) {
			System.out.println(empSal *6/100 );
		}
	else if(empSal>30000 && empSal<50000 &&isIndian==true) {
		System.out.println(empSal *5/100 );
		
	}
	else if(empSal>10000 && empSal<300000 &&isIndian==true) {
		System.out.println(empSal *4/100  );
		
	}else {
		try {
			throw new TaxNotEligibleException("The employee does not need to pay tax:");
			
		}catch(TaxNotEligibleException e) {
			System.out.println(e.getMessage());
		}}}}
 class CalculatorSimulator {
	 public static void main(String[] args) throws Exception {
		TaxCalculator r=new TaxCalculator();
		r.calculateTax("puja",false,4500);
		r.calculateTax("nik",true,1000);
		r.calculateTax("puja",true,45000);
		r.calculateTax("puja",true,30000);
		
	}
 }
