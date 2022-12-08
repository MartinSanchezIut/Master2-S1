elmt = ["searching_a_flight","booking_a_flight","changing_a_reservation","paying_a_booked_flight","assign_seat",
"validate_passenger","check_in_luggage","searching_a_flight","booking_a_flight","changing_a_reservation",
"paying_a_booked_flight","assign_seat","validate_passenger","check_in_luggage","searching_a_flight",
"booking_a_flight","booking_a_flight_by_airline_company","booking_a_flight_by_travel_platform",
"changing_a_reservation","searching_a_flight","booking_a_flight","changing_a_reservation",
"paying_a_booked_flight","assign_seat","validate_passenger","check_in_luggage","check_in_luggage",
"change_seat","searching_a_flight","booking_a_flight","changing_a_reservation","paying_a_booked_flight",
"choose_seat","check_in_luggage","pay_extra_luggage","validate_passenger"]

mylist = list(set(elmt))
#print(mylist) 
#print(len(mylist))

l = []
for x in mylist:
	l.append("c_" + str(x))
	l.append("ac_" + str(x))
	l.append("tae_" + str(x))

#print(l)
line = []
for i in range(1, 5):
	print(i)

	for x in l:
		a = input(str(x) + " ?")
		line.append(str(a))

	print(line)