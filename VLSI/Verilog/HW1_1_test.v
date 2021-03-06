module Mut2_1_test;
reg [1:0] In;
reg sel;
wire out;

Mut2_1 M1(out, In, sel);

initial 
begin
	$monitor($time, "out=%b, In=%b, sel=%b\n", out, In, sel);
	#5 In = 2'b00; sel = 1'b0;
	#5 In = 2'b01; sel = 1'b0;
	#5 In = 2'b10; sel = 1'b0;
	#5 In = 2'b11; sel = 1'b0;
	#5 In = 2'b00; sel = 1'b1;
	#5 In = 2'b01; sel = 1'b1;
	#5 In = 2'b10; sel = 1'b1;
	#5 In = 2'b11; sel = 1'b1;

end
endmodule
