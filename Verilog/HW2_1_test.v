module HalfAdder_test;
reg A, B;
wire Sum, Carry;

HalfAdder HA(Sum, Carry, A, B);

initial 
begin
	$monitor($time, "Sum=%b, Carry=%b, A=%b, B=%b\n", Sum, Carry, A, B);
	#5 A = 1'b0; B = 1'b0;
	#5 A = 1'b1; B = 1'b0;
	#5 A = 1'b1; B = 1'b1;
	#5 A = 1'b0; B = 1'b1;
end
endmodule
