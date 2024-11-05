#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#pragma warning (disable : 4996)

int main()
{

	int tnc, tlc, tic, incr, tdd, tdr, oneortwo, tut, dff, day, rcd;
	int arr[10] = { 9, 100, 2, 10, 0, 0, 0, 0, 0, 0 };
	float rd, rr, rdt, ddr, drr, rdut, rdd, rdr;
	char constoLe;
	int count[4] = { 0,0,0,0 };
	printf("=============================================================================================\n");
	//day
	printf("Enter the Day Number : ");
	scanf("%d", &day);
	printf("=============================================================================================\n");
	arr[8] = day;
	do {


		tnc = arr[1] - arr[2] - arr[3];
		rd = (float)arr[2] / (float)arr[1] * 100;
		rr = (float)arr[3] / (float)arr[1] * 100;
		rdt = (float)tnc / (float)arr[1] * 100;

		printf("================= COVID-19 CASES Tracking Sytstem =================\n");
		printf("      Yesterday's Totals - (Day %d):\n", day);
		printf("+--------------------+-----------++-----------+-----------+-----------+\n");
		printf("|        Yesterday's | Total     || Total     | Total     | Under     |\n");
		printf("|        Cases       | Cases     || Deaths    | Recovered | treatment |\n");
		printf("+--------------------+-----------++-----------+-----------+-----------+\n");
		printf("|              %-3d   | %-3d       ||  %-3d      |  %-3d      |  %-3d      |\n", arr[0], arr[1], arr[2], arr[3], tnc);
		printf("+---------------------------------------------------------------------+\n");
		printf("                                 ||  %.1f%%     |  %.1f%%    |  %.1f%%    |\n", rd, rr, rdt);
		printf("                                 ++-----------------------------------+\n\n");
		//Enter Cases
		printf("=============================================================================================\n");
		printf("Enter number of new local cases : ");
		scanf("%d", &tlc);
		printf("Enter number of new imported cases : ");
		scanf("%d", &tic);
		printf("Enter number of deaths : ");
		scanf("%d", &tdd);
		printf("Enter number of recovered : ");
		scanf("%d", &tdr);
		printf("=============================================================================================\n");
		printf("Day %d\n", day + 1);
		printf("======\n");

		printf("Key in Today's data:\n");
		printf("        No. of new local cases    : %d\n", tlc);
		printf("        No. of new imported cases : %d\n", tic);

		arr[4] = tlc + tic;
		incr = arr[4] - arr[0];

		if (incr > 0) {
			printf("Total no.of new cases = %d      (Increased by %d from yesterday)\n", arr[4], incr);
		}

		else if (incr < 0) {
			incr = abs(incr);
			printf("Total no.of new cases = %d      (Decreased by %d from yesterday)\n", arr[4], incr);
		}

		else if (incr == 0) {
			printf("Total no.of new cases = %d      (No changed from yesterday)\n", arr[4]);
		}


		printf("No. of deaths         = %d\n", tdd);
		printf("No. recovered         = %d\n\n", tdr);

		printf("1 - Daily Summary Report      2 - Daily Comparative Report\n");
		printf("What type of Report would you like to view (Choose 1 or 2)? ");
		scanf("%d", &oneortwo);
		printf("=============================================================================================\n");
		arr[5] = arr[1] + arr[4];
		arr[6] = arr[2] + tdd;
		arr[7] = arr[3] + tdr;
		tut = arr[5] - arr[6] - arr[7];
		ddr = (float)arr[6] / (float)arr[5] * 100;
		drr = (float)arr[7] / (float)arr[5] * 100;
		rdut = (float)tut / (float)arr[5] * 100;
		dff = arr[5] - arr[1];
		rdd = ddr - rd;
		rdr = drr - rr;
		if (day < 2) {
			count[0] = arr[0];
			count[1] = day;
		}
		day++;
		if (arr[4] > arr[0])
		{
			count[0] = arr[4];
			count[1] = day;
		}
		if (arr[4] < arr[0])
		{
			count[2] = arr[4];
			count[3] = day;
		}

		if (oneortwo == 1) {
			printf("\n                                    DAILY SUMMARY REPORT\n");
			printf(" +--------------------+-----------++-----------+-----------+-----------+\n");
			printf(" |            Today's | Total     || Total     | Total     | Under     |\n");
			printf(" |            Cases   | Cases     || Deaths    | Recovered | treatment |\n");
			printf(" +--------------------+-----------++-----------+-----------+-----------+\n");
			printf(" | local      %-2d      |           ||           |           |           |\n", tlc);
			printf(" | imported   %-2d      |           ||           |           |           |\n", tic);
			printf(" |               %-3d  |   %-3d     ||    %-3d    |   %-3d     |   %-3d     |\n", arr[4], arr[5], arr[6], arr[7], tut);
			printf(" +--------------------------------++-----------+-----------+-----------+\n");
			printf("                                  ||    %-2.1f%%   |   %-2.1f%%   |   %-2.1f%%   |\n", ddr, drr, rdut);
			printf("                                  ++-----------------------------------+\n\n");
			printf(" ------------------------ End of Day %d Reporting ------------------------\n\n", day);

		}

		else if (oneortwo == 2) {
			printf("                              DAILY COMPARATIVE REPORT\n");
			printf("                             + ------------ + ------------++------------ +\n");
			printf("                             |  YESTERDAY   |    TODAY    ||  DIFFERENCE |\n");
			printf("                             |   Day %-2d     |    Day %-2d   ||             |\n", day - 1, day);
			printf("+--------------------------- + ------------ + ------------++------------ +\n");
			printf("|  New Cases                 |    %-5d     |    %-5d    ||  [ %-5d ]  |\n", arr[0], arr[4], incr);
			printf("+--------------------------- + ------------ + ------------++------------ +\n");
			printf("|  TOTAL Cases               |    %-5d     |    %-5d    ||  [ %-5d ]  |\n", arr[1], arr[5], dff);
			printf("+--------------------------- + ------------ + ------------++------------ +\n");
			printf("|  Death Rate                |    %5.1f %%   |    %5.1f %%  ||  [ %5.1f %% ]|\n", rd, ddr, rdd);
			printf("+--------------------------- + ------------ + ------------++------------ +\n");
			printf("|  Recovery Rate             |    %5.1f %%   |    %5.1f %%  ||  [ %5.1f %% ]|\n", rr, drr, rdr);
			printf("+--------------------------- + ------------ + ------------++------------ +\n");
			printf("==========================End of Day %d Reporting==========================\n\n", day);
		}

		else if (oneortwo > 2) {
			printf("    _______\n");
			printf("   |.-----.|\n");
			printf("   ||x . x||\n");
			printf("   ||_.-._||     !!PLS RETYPE YOUR NUMBER!!                  \n");
			printf("   `--)-(--`\n");
			printf("  __[=== o]___\n");
			printf("  |:::::::::::|\n");
			printf("  =============\n");
			exit(0);
		}
		do {
			arr[0] = arr[4];
			arr[1] = arr[5];
			arr[2] = arr[6];
			arr[3] = arr[7];
			arr[9] = day;
			printf("Continue to Next Day (Y = Yes / N = No)? ");
			scanf(" %c", &constoLe);
		} while (constoLe != 'Y' && constoLe != 'y' && constoLe != 'N' && constoLe != 'n');
	} while (constoLe != 'N' && constoLe != 'n');

	rcd = arr[9] - arr[8] + 1;
	printf("TOTAL Days recorded = %d days (Day %d to Day %d)\n", rcd, arr[8], arr[9]);
	printf("HIGHEST number of cases = %d, occurring on Day %d\n", count[0], count[1]);
	printf("LOWEST number of cases = %d, occurring on Day %d\n\n", count[2], count[3]);
	printf("========================================Bye and Thank You========================================\n");
	printf("====================================Staying home , Saves life====================================\n");
	if (count[0] >= 100) {
		printf("  _______________\n");
		printf(" |  ___________  |   \n");
		printf(" | |           | |   \n");
		printf(" | |   X   X   | |   \n");
		printf(" | |     -     | |   \n");
		printf(" | |    ___    | |      \n");
		printf(" | |___     ___| |     \n");
		printf(" |_____|   |_____|  \n");
		printf("   _|__|   |_|_\n");

	}

	else {
		printf("  _______________\n");
		printf(" |  ___________  |   \n");
		printf(" | |           | |   \n");
		printf(" | |   0   0   | |   \n");
		printf(" | |     -     | |   \n");
		printf(" | |    ___    | |      \n");
		printf(" | |___     ___| |     \n");
		printf(" |_____|   |_____|  \n");
		printf("   _|__|   |_|_\n");

	}
}