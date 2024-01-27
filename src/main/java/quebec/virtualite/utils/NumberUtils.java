package quebec.virtualite.utils;

public class NumberUtils
{
    public static boolean isNullOrZero(Float... values)
    {
        for (Float value : values)
        {
            if (value == null
                || value == 0f)
                return true;
        }

        return false;
    }

    public static float round(float value, int numDecimals)
    {
        float factor = (float) Math.pow(10, numDecimals);
        return Math.round(value * factor) / factor;
    }
}
