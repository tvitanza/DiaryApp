package DiaryAppPackage;

import java.util.List;

public interface IDiaryUI {

    String showMenu();

    int showDeleteForm();

    Diary showUpdateForm();

    Diary showAddForm();

    void showList(List<Diary> diaryList);
}
