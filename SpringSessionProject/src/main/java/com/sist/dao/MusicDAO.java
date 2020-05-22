package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 *   Spring���� �޸� �Ҵ� 
 *   = @Component : �Ϲ� Ŭ���� (MainClass,~Manager,�ܺο��� ������ �о�´�)
 *   = @Repository : DAO
 *   = @Controller : Model => ~Controller(Spring),~Action,~Model(���������)
 *   = @RestController : JSON,XML => (Ajax,React)
 *   ***= @Service : DAO�� ������ �����ؼ� ��� => BI
 *   
 *   Spring에서 DI
 *   = @Autowired
 *   = @Resource
 *   ***= @Inject
 *   ***= @Import
 *   
 *   interface A
 *   interface B
 *   class MapperFactoryBean implements A,B =>인터페이스는 다중 구현이 가능하다.
 *   
 *   
 */
@Repository
public class MusicDAO {
   @Autowired
   private MusicMapper mapper;
   
   @Autowired
   private MovieMapper movieMpper;
   
   public List<MusicVO> musicListData()
   {
	   return mapper.musicListData();
   }
   public MusicVO musicDetailData(int mno)
   {
	   return mapper.musicDetailData(mno);
   }
   public int idCount(String id)
   {
	   return mapper.idCount(id);
   }
   // ssf.openSession(true)
   // 
   public String memberGetPassword(String id)
   {
	   return mapper.memberGetPassword(id);
   }
}


















