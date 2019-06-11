module main_clock();
input Clock_1sec, reset, load_time, set_hours, set_mins, set_sec, set_am_pm, load_alarm, alarm_hours_in, alarm_mins_in, alarm_am_pm_in, alarm_enable;
output hours, mins, secs, am_pm, flashing, alarm;