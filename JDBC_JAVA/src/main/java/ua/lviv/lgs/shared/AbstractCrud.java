package ua.lviv.lgs.shared;

import java.util.List;

public interface AbstractCrud <T> {

	 T create (T t);
	 T reade (Integer id);
	 List<T> readeAll();
	 T update (T t);
	 void delete (Integer id);
}
