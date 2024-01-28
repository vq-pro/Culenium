package quebec.virtualite.culenium.page_object;

@FunctionalInterface
public interface RunnableNoTry
{
    public abstract void run() throws Exception;
}
