/**
 * By Brandon Fifield: March 27th, 2017  Student I.D.:201238730
 * A C++ program that constucts different kinds of appointments.
 */

#include "../std_lib_facilities.h"
#include <ctime>


class Appointment {
	protected:
		string description;
		tm time;
	public:
		Appointment(string des, tm t) : description{des}, time{t} {};
		virtual bool occurs_on(int year, int month, int day) {
			if(time.tm_year+(1900) == year && time.tm_mon+(1) == month && time.tm_mday == day) {
				return true;
			}
			return false;
		}
};


class Onetime : public Appointment {
	public:
		Onetime(string des, tm t) : Appointment{des,t} {}	
};


class Daily : public Appointment {
	public:
		Daily(string des, tm t) : Appointment{des,t} {}
};


class Weekly : public Appointment {
	public:
		Weekly(string des, tm t) : Appointment{des,t} {}

};


class Monthly : public Appointment {
	public:
		Monthly(string des, tm t) : Appointment{des,t} {}
		bool occurs_on(int year, int month, int day) {
			if(time.tm_mon == month && time.tm_mday == day) {
				return true;
			}
			return false;
		}
};


int main() {

	/**
		These operations will test for inheritence between the two classes.
	**/
	Appointment appointment{"Just an appointment", tm{0,30,11,15,10,117}};
	Onetime onetime{"Just a onetime appointment", tm{0,10,9,15,10,117}};

	cout << "Does the appointment occur on 15/9/2017?: ";
	if(appointment.occurs_on(2017,11,15)) {
		cout << "Yes" << endl;
	}
	else {
		cout << "No" << endl;
	}

	cout << "Does the onetime appointment occur on 15/9/2017?: ";
	if(onetime.occurs_on(2017,11,15)) {
		cout << "Yes" << endl;
	}
	else {
		cout << "No" << endl;
	}

	return 0;
}
