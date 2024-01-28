package quebec.virtualite.utils;

@FunctionalInterface
public interface RunnableNoTry
{
    public abstract void run() throws Exception;
}
