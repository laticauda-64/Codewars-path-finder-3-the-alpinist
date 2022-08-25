import org.example.foo.RomanNumerals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsTest {

    @Test
    void testIntToRoman() {
        assertEquals("III", RomanNumerals.toRoman(3));
        assertEquals("XVI", RomanNumerals.toRoman(16));
        assertEquals("CXXXVII", RomanNumerals.toRoman(137));
        assertEquals("D", RomanNumerals.toRoman(500));
        assertEquals("DCLXXXIX", RomanNumerals.toRoman(689));
        assertEquals("MCDL", RomanNumerals.toRoman(1450));
        assertEquals("MM", RomanNumerals.toRoman(2000));
        assertEquals("MMMCMXCIX", RomanNumerals.toRoman(3999));

    }

}
