module first_circuit_test;
reg A, B, C, D;
wire F;

first_circuit M1(F, A, B, C, D);

initial 
begin
	$monitor($time, "F=%b, A=%b, B=%b, C=%b, D=%b\n", F, A, B, C, D);
	#5 A = 1'b0; B = 1'b0; C = 1'b0; D = 1'b1;
	#5 A = 1'b0; B = 1'b1; C = 1'b0; D = 1'b1;
	#5 A = 1'b0; B = 1'b1; C = 1'b1; D = 1'b1;
	#5 A = 1'b1; B = 1'b0; C = 1'b0; D = 1'b1;
	#5 A = 1'b1; B = 1'b1; C = 1'b0; D = 1'b1;
	#5 A = 1'b1; B = 1'b1; C = 1'b1; D = 1'b1;
end
endmodule
