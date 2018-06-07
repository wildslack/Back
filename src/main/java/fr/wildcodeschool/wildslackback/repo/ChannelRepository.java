package fr.wildcodeschool.wildslackback.repo;

import fr.wildcodeschool.wildslackback.model.AppUser;
import fr.wildcodeschool.wildslackback.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ChannelRepository extends JpaRepository<Channel, Long> {

    Channel findByName(String name);

    //@Query(value = "SELECT c FROM Channel c JOIN c.appUsers u WHERE u.id =:idUser")
    @Query(value = "select * from channel where id_channel in ( select id_channel from channel_users where id_user = ?1)",nativeQuery = true)
    List<Channel> findChannelsByAppUser(@Param("idUser") long idUser);

    @Query(value = "select * from channel  where id_channel in ( select id_channel from channel_users where id_user = ?1) and default_channel=true", nativeQuery = true)
    Channel findDefaultChannel(@Param("idUser") long idUser);

    Channel findByIdChannel(long idChannel);

    @Query(value = "select * from channel where workspace_id_workspace =?1",nativeQuery = true)
    List<Channel> findAllByWorkspace(@Param("idWorkspace") long idWorkspace );

    @Query(value = "select * from channel where id_channel in(select last_chan from app_user where id_user = ?1)",nativeQuery = true)
    Channel findLastChannel(@Param("idUser") Long idUser);


}
