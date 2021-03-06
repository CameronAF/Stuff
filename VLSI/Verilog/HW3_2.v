module moore_serial_adder(sum, carry, A, B, clk, reset);
output sum, carry;
input A, B, clk, reset;
reg sum, carry;
reg [1:0] pres_state;
parameter	S0 = 2'b00,
		S1 = 2'b01,
		S2 = 2'b10,
		S3 = 2'b11;

initial
	pres_state = S0;

always@(reset)
begin
	if(reset == 1'b1)
		pres_state = S0;
end

always@(A or B)
begin
	case(pres_state)
	S0:
		if(A == 1'b0 && B == 1'b0)
			pres_state = S0;
		else if(A == 1'b1 && B == 1'b1)
			pres_state = S2;
		else 
			pres_state = S1;
	S1:
		if(A == 1'b0 && B == 1'b0)
			pres_state = S0;
		else if(A == 1'b1 && B == 1'b1)
			pres_state = S2;
		else 
			pres_state = S1;
	S2:
		if(A == 1'b0 && B == 1'b0)
			pres_state = S1;
		else if(A == 1'b1 && B == 1'b1)
			pres_state = S3;
		else 
			pres_state = S2;
	S3:
		if(A == 1'b0 && B == 1'b0)
			pres_state = S1;
		else if(A == 1'b1 && B == 1'b1)
			pres_state = S3;
		else 
			pres_state = S2;
	endcase
end

always@(clk)
begin
	case(pres_state)
	S0:
		begin
		sum = 1'b0;
		carry = 1'b0;
		end
	S1:
		begin
		sum = 1'b1;
		carry = 1'b0;
		end
	S2:
		begin
		sum = 1'b0;
		carry = 1'b1;
		end
	S3:
		begin
		sum = 1'b1;
		carry = 1'b1;
		end
	endcase
end
endmodule
