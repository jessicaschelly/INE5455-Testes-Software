package testes_joda_time;

import static org.junit.Assert.*;

import org.joda.time.IllegalFieldValueException;
import org.joda.time.*;
import org.junit.Test;

public class TesteJodaTime {

	@Test
	public void createChristmasDate() {
		// Fixture Setup
		LocalDate natal2020 = new LocalDate(2020, 12, 25);
		// Exercise SUT
		int getAno = natal2020.getYear();
		int getMes = natal2020.getMonthOfYear();
		int getDia = natal2020.getDayOfMonth();
		// Result Verification
		assertEquals(2020, getAno);
		assertEquals(12, getMes);
		assertEquals(25, getDia);
		// Fixture Teardown
	}

	@Test(expected = IllegalFieldValueException.class)
	public void createDateInvalid() {
		// Fixture Setup
		// Exercise SUT
		LocalDate dataInvalida = new LocalDate(2017, 1, -1);
		// Result Verification
		// Fixture Teardown
	}

	@Test(expected = IllegalFieldValueException.class)
	public void createDateWithMonthInvalid() {
		// Fixture Setup
		// Exercise SUT
		LocalDate dataInvalida = new LocalDate(2017, -1, 1);
		// Result Verification
		// Fixture Teardown
	}

	@Test(expected = IllegalFieldValueException.class)
	public void createDateYearInvalid() {
		// Fixture Setup
		// Exercise SUT
		LocalDate dataInvalida = new LocalDate(-2017, -1, 1);
		// Result Verification
		// Fixture Teardown
	}

	@Test(expected = IllegalFieldValueException.class)
	public void createInvalidDate() {
		// Fixture Setup
		// Exercise SUT
		LocalDate dataInvalida = new LocalDate(0, 0, 0);
		// Result Verification
		// Fixture Teardown
	}

	@Test(expected = IllegalFieldValueException.class)
	public void createDateInvalidFormat() {
		// Fixture Setup
		// Exercise SUT
		LocalDate dataInvalida = new LocalDate(12, 2016, 1);
		// Result Verification
		// Fixture Teardown
	}

	@Test
	public void sumDate() {
		// Fixture Setup
		LocalDate data = new LocalDate(2020, 3, 14);
		LocalDate novaData = new LocalDate(2020, 3, 21);
		// Exercise SUT
		LocalDate getDataSomada = data.plusDays(7);
		// Result Verification
		assertEquals(novaData, getDataSomada);
		// Fixture Teardown
	}

	@Test(expected = IllegalFieldValueException.class)
	public void createDateLeapYearInvalid() {
		// Fixture Setup
		// Exercise SUT
		LocalDate dia29Fevereiro = new LocalDate(2019, 2, 29);
		// Result Verification
		// Fixture Teardown
	}

	@Test
	public void subtractDate() throws Exception {
		// Fixture Setup
		LocalDate data = new LocalDate(2020, 3, 14);
		LocalDate novaData = new LocalDate(2020, 3, 7);
		// Exercise SUT
		LocalDate getDataSubtraida = data.minusDays(7);
		// Result Verification
		assertEquals(novaData, getDataSubtraida);
		// Fixture Teardown
	}
	
	@Test(expected = IllegalFieldValueException.class)
	public void createInvalidHour() {
		// Fixture Setup
		// Exercise SUT
		LocalTime hora = new LocalTime(26, 0);
		// Result Verification
		// Fixture Teardown
	}
	
	@Test(expected = IllegalFieldValueException.class)
	public void createHourWihtInvalidMinute() {
		// Fixture Setup
		// Exercise SUT
		LocalTime hora = new LocalTime(12, 60);
		// Result Verification
		// Fixture Teardown
	}
	
	@Test(expected = IllegalFieldValueException.class)
	public void createHourWithInvalidSeconds() {
		// Fixture Setup
		// Exercise SUT
		LocalTime hora = new LocalTime(12, 30, 89);
		// Result Verification
		// Fixture Teardown
	}
	
	@Test(expected = IllegalFieldValueException.class)
	public void createHourWithMillisInvalid() {
		// Fixture Setup
		// Exercise SUT
		LocalTime hora = new LocalTime(12, 30, 30, 1000);
		// Result Verification
		// Fixture Teardown
	}

	@Test
	public void sumOneMinute() {
		// Fixture Setup
		LocalTime meioDia = new LocalTime(12, 0);
		LocalTime meioDiaEUm = new LocalTime(12, 1);
		// Exercise SUT
		LocalTime getMeioDiaPlusOneMin = meioDia.plusMinutes(1);
		// Result Verification
		assertEquals(meioDiaEUm, getMeioDiaPlusOneMin);
		// Fixture Teardown
	}

	@Test
	public void subtractOneMinute() {
		// Fixture Setup
		LocalTime meioDia = new LocalTime(22, 0);
		LocalTime meioDiaMenosUm = new LocalTime(21, 59);
		// Exercise SUT
		LocalTime getMeioDiaMinusOne = meioDia.minusMinutes(1);
		// Result Verification
		assertEquals(meioDiaMenosUm, getMeioDiaMinusOne);
		// Fixture Teardown
	}

	@Test
	public void beforeDate() {
		// Fixture Setup
		// Exercise SUT
		LocalDate date1 = new LocalDate(2020, 5, 14);
		LocalDate date2 = new LocalDate(2020, 3, 10);
		// Result Verification
		assertTrue(date2.isBefore(date1));
		// Fixture Teardown
	}

	@Test
	public void afterDate() {
		// Fixture Setup
		// Exercise SUT
		LocalDate date1 = new LocalDate(2020, 5, 20);
		LocalDate date2 = new LocalDate(2020, 6, 16);
		// Result Verification
		assertTrue(date2.isAfter(date1));
		// Fixture Teardown
	}

	@Test
	public void createDateAndHour() {
		// Fixture Setup
		LocalDateTime dataHoraMinSec = new LocalDateTime(2020, 3, 11, 11, 30,
				0, 000);
		// Exercise SUT
		int getDataMes = dataHoraMinSec.getMonthOfYear();
		int getDataDia = dataHoraMinSec.getDayOfMonth();
		int getDataHora = dataHoraMinSec.getHourOfDay();
		int getDataMin = dataHoraMinSec.getMinuteOfHour();
		int getDataSec = dataHoraMinSec.getSecondOfMinute();
		int getDataMillis = dataHoraMinSec.getMillisOfSecond();
		// Result Verification
		assertEquals(2020, dataHoraMinSec.getYear());
		assertEquals(DateTimeConstants.MARCH, getDataMes);
		assertEquals(11, getDataDia);
		assertEquals(11, getDataHora);
		assertEquals(30, getDataMin);
		assertEquals(0, getDataSec);
		assertEquals(0, getDataMillis);
		// Fixture Teardown
	}

	@Test
	public void validateNoon() {
		// Fixture Setup
		LocalTime meioDia = new LocalTime(12, 00, 00, 00);
		// Exercise SUT
		int meioDiaHora = meioDia.getHourOfDay();
		int meioDiaMinuto = meioDia.getMinuteOfHour();
		int meioDiaSec = meioDia.getSecondOfMinute();
		int meioDiaMillis = meioDia.getMillisOfSecond();
		// Result Verification
		assertEquals(12, meioDiaHora);
		assertEquals(00, meioDiaMinuto);
		assertEquals(00, meioDiaSec);
		assertEquals(00, meioDiaMillis);
		// Fixture Teardown
	}

	@Test
	public void validateMidnight() {
		// Fixture Setup
		LocalTime meiaNoiteEmPonto = new LocalTime(0, 0, 0, 0);
		// Exercise SUT
		int meiaNoiteHora = meiaNoiteEmPonto.getHourOfDay();
		int meiaNoiteMin = meiaNoiteEmPonto.getMinuteOfHour();
		int meiaNoiteSec = meiaNoiteEmPonto.getSecondOfMinute();
		int meiaNoiteMillis = meiaNoiteEmPonto.getMillisOfSecond();
		// Result Verification
		assertEquals(0, meiaNoiteHora);
		assertEquals(0, meiaNoiteMin);
		assertEquals(0, meiaNoiteSec);
		assertEquals(0, meiaNoiteMillis);
		// Fixture Teardown
	}

	@Test
	public void sumOneMinuteToNoon() {
		// Fixture Setup
		LocalTime meioDia = new LocalTime(12, 00, 00, 00);
		// Exercise SUT
		LocalTime meioDiaPlusOne = meioDia.plusMinutes(1);
		int getHora = meioDiaPlusOne.getHourOfDay();
		int getMinute = meioDiaPlusOne.getMinuteOfHour();
		// Result Verification
		assertNotEquals(meioDiaPlusOne, meioDia);
		assertEquals(12, getHora);
		assertEquals(01, getMinute);
		// Fixture Teardown
	}

	@Test
	public void IntervalContains() {
		// Fixture Setup
		DateTime onzeEvinteEdois = new DateTime(2020, 3, 14, 11, 22);
		DateTime onzeEmeia = new DateTime(2020, 3, 14, 11, 30);
		DateTime meioDia = new DateTime(2020, 3, 14, 12, 00);
		// Exercise SUT
		Interval interval = new Interval(onzeEvinteEdois, meioDia);
		// Result Verification
		assertTrue(interval.contains(onzeEmeia));
		// Fixture Teardown
	}

	@Test
	public void AfterEqualDates() {
		// Fixture Setup
		LocalTime meiaNoite = new LocalTime(23, 59, 59, 999);
		// Exercise SUT
		// Result Verification
		assertFalse(meiaNoite.isAfter(meiaNoite));
		// Fixture Teardown
	}

	@Test
	public void BeforeEqualDates() {
		// Fixture Setup
		// Exercise SUT
		LocalTime meiaNoite = new LocalTime(23, 59, 59, 999);
		// Result Verification
		assertFalse(meiaNoite.isBefore(meiaNoite));
	}

	@Test
	public void subtractOneMillisFromMidnight() {
		// Fixture Setup
		LocalTime zeroHora = new LocalTime(00, 00, 00, 00);
		LocalTime meiaNoite = zeroHora.minusMillis(1);
		// Exercise SUT
		int getHora = meiaNoite.getHourOfDay();
		int getMinute = meiaNoite.getMinuteOfHour();
		int getSecond = meiaNoite.getSecondOfMinute();
		int getMillis = meiaNoite.getMillisOfSecond();
		// Result Verification
		assertNotEquals(zeroHora, meiaNoite);
		assertEquals(23, getHora);
		assertEquals(59, getMinute);
		assertEquals(59, getSecond);
		assertEquals(999, getMillis);
		// Fixture Teardown
	}

	@Test
	public void subtractOneMillisFromNoon() {
		// Fixture Setup
		LocalTime meioDia = new LocalTime(12, 00, 00, 00);
		LocalTime onzeEcinquentaEnove = meioDia.minusMinutes(1);
		// Exercise SUT
		int getHour = onzeEcinquentaEnove.getHourOfDay();
		int getMinutes = onzeEcinquentaEnove.getMinuteOfHour();
		// Result Verification
		assertNotEquals(onzeEcinquentaEnove, meioDia);
		assertEquals(11, getHour);
		assertEquals(59, getMinutes);
		// Fixture Teardown
	}

	@Test
	public void sumOneMillisToMidnight() {
		// Fixture Setup
		LocalTime zeroHora = new LocalTime(00, 00, 00, 00);
		LocalTime meiaNoiteEUmMillis = zeroHora.plusMillis(1);
		// Exercise SUT
		int getHora = meiaNoiteEUmMillis.getHourOfDay();
		int getMinute = meiaNoiteEUmMillis.getMinuteOfHour();
		int getSecond = meiaNoiteEUmMillis.getSecondOfMinute();
		int getMillis = meiaNoiteEUmMillis.getMillisOfSecond();
		// Result Verification
		assertNotEquals(zeroHora, meiaNoiteEUmMillis);
		assertEquals(00, getHora);
		assertEquals(00, getMinute);
		assertEquals(00, getSecond);
		assertEquals(01, getMillis);
		// Fixture Teardown
	}

	@Test
	public void testPeriod() {
		// Fixture Setup
		DateTime inicio = new DateTime(2020, 03, 11, 13, 20);
		DateTime fim = new DateTime(2020, 03, 11, 16, 50);
		Period periodo = new Period(inicio, fim);
		// Exercise SUT
		int getHora = periodo.getHours();
		int getMinutes = periodo.getMinutes();
		// Result Verification
		assertEquals(3, getHora);
		assertEquals(30, getMinutes);
		// Fixture Teardown
	}
	
	@Test
	public void compareTextEqualMonths() {
		// Fixture Setup
		// Exercise SUT
		LocalDate dateOfBirth = new LocalDate(1999, 3, 18);
		String getMonthAsText = dateOfBirth.monthOfYear().getAsText();
		// Result Verification
		assertEquals ("Março", getMonthAsText);
		// Fixture Teardown
	}
	
	@Test
	public void compareTextDifferentsMonths(){
		// Fixture Setup
		LocalDate dateOfBirth = new LocalDate(1999, 3, 18);
		// Exercise SUT
		String getMonthAsText = dateOfBirth.monthOfYear().getAsText();
		// Result Verification
		assertNotEquals ("Abril", getMonthAsText);
		// Fixture Teardown
	}
}
