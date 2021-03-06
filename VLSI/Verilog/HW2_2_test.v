module FullAdder_test;
reg A, B, C;
wire Sum, Carry;

FullAdder FA(Sum, Carry, A, B, C);

initial 
begin
	$monitor($time, "Sum=%b, Carry=%b, A=%b, B=%b, C=%b\n", Sum, Carry, A, B, C);
	#5 A = 1'b0; B = 1'b0; C = 1'b0;
	#5 A = 1'b0; B = 1'b0; C = 1'b1;
	#5 A = 1'b0; B = 1'b1; C = 1'b0;
	#5 A = 1'b0; B = 1'b1; C = 1'b1;
	#5 A = 1'b1; B = 1'b0; C = 1'b0;
	#5 A = 1'b1; B = 1'b0; C = 1'b1;
	#5 A = 1'b1; B = 1'b1; C = 1'b0;
	#5 A = 1'b1; B = 1'b1; C = 1'b1;
end
endmodule