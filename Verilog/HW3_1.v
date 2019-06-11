module mealy_serial_adder(sum, carry, A, B, clk, reset);
output sum, carry;
input A, B, clk, reset;
reg sum, carry;
reg pres_state, next_state, prev_state;
parameter	S0 = 1'b0,
		S1 = 1'b1;

initial
begin
	next_state = S0;
	prev_state = S0;
   	pres_state = S0;
end

always@(clk)
begin : Change_State
	if(reset == 1'b1) begin
		next_state = S0;
		prev_state = S0;
   		pres_state = S0;
	end
	else begin
		prev_state = pres_state;
		pres_state = next_state;
	end
end

always@(pres_state or A or B)
begin : Sequence
	case(pres_state)
	S0:
		if(A == 1'b1 && B == 1'b1)
			next_state = S1;
	S1:
		if(A == 1'b0 && B == 1'b0)
			next_state = S0;
	endcase
end

always@(clk)
begin : Output_Logic
	if(reset == 1'b1) begin
		sum = 1'b0;
		carry = 1'b0;
	end 
	else begin
		case(pres_state)
			S0: begin
				carry = 1'b0;
				if(prev_state == S0 && A == 1'b0 && B == 1'b0)
					sum = 1'b0;
				else
					sum = 1'b1;
			end
			S1: begin
				carry = 1'b1;
				if(prev_state == S1 && A == 1'b1 && B == 1'b1)
					sum = 1'b1;
				else
					sum = 1'b0;
				end
		endcase
	end
end
endmodule
