module mealy_serial_adder_test;
reg A, B, clk, reset;
wire sum, carry;

mealy_serial_adder SA(sum, carry, A, B, clk, reset);

initial 
begin
	clk = 1'b0;
	$monitor($time, "sum=%b, carry=%b, A=%b, B=%b, clk, reset\n", sum, carry, A, B, clk, reset);
	#5 A = 1'b1; B = 1'b0; reset = 1'b0;  	//sum = 1 , carry = 0
	#10 A = 1'b0; B = 1'b1; reset = 1'b0;	//sum = 1 , carry = 0
	#10 A = 1'b1; B = 1'b1; reset = 1'b0;	//sum = 0 , carry = 1
	#10 A = 1'b1; B = 1'b1; reset = 1'b0;	//sum = 1 , carry = 1
	#10 A = 1'b0; B = 1'b0; reset = 1'b0;	//sum = 1 , carry = 0
	#10 A = 1'b1; B = 1'b1; reset = 1'b0;	//sum = 0 , carry = 1
	#10 A = 1'b1; B = 1'b0; reset = 1'b1;	//sum = 0 , carry = 0
	#10 A = 1'b1; B = 1'b1; reset = 1'b0;	//sum = 0 , carry = 1
	#10 A = 1'b0; B = 1'b0; reset = 1'b0;	//sum = 1 , carry = 0
	#10 A = 1'b0; B = 1'b0; reset = 1'b0;	//sum = 0 , carry = 0
end

always
begin
	#10 clk = ~clk;
end
endmodule
