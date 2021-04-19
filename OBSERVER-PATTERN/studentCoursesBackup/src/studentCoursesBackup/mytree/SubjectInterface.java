package studentCoursesBackup.myTree;

public interface SubjectInterface
{
    void registerObserver(ObserverInterface oIn);
    void removeObserver(ObserverInterface oIn);
    public void notifyAll(String sIn);
}

