package DiaryAppPackage;

import java.util.ArrayList;
import java.util.List;

public class MemoryDao implements IDiaryDao {
    private final List<Diary> diaryList = new ArrayList<>();

    @Override
    public void add(Diary diary) {
        diaryList.add(diary);
    }

    @Override
    public void delete(int id) {
        for (Diary diary : diaryList) {
            if (diary.getId() == id) {
                diaryList.remove(diary);
                return;
            }
        }
    }

    @Override
    public List<Diary> fetch() {
        return diaryList;
    }

    @Override
    public void update(Diary diary) {
        for (Diary d : diaryList) {
            if (d.getId() == diary.getId()) {
                diaryList.remove(d);
                diaryList.add(diary);
            }
        }
    }
}

