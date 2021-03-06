/* Objective: Creating four digits
 * 1.	Make four instances of "Adding Seven Segment Display"
 */
module hierarchy(ms_hr, ls_hr, ms_min, ls_min,dis_time);
output [7:0] ms_hr, ls_hr, ms_min, ls_min;
input [15:0] dis_time;

seg_display hr2(ms_hr, dis_time[15:12]);
seg_display hr1(ls_hr, dis_time[11:8]);
seg_display min2(ms_min, dis_time[7:4]);
seg_display min1(ls_min, dis_time[3:0]);

endmodule
