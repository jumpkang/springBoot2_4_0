package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

@SpringBootApplication
@Slf4j
public class KangJedisSentinelApplication implements CommandLineRunner {

	@Autowired
	private RedisTemplate jedis;

	public static void main(String[] args) {
		SpringApplication.run(KangJedisSentinelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		for(int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					HostAndPort hap = HostAndPort.parseString("10.122.46.41:9379");
					final Jedis mJ = new Jedis(hap);
					int j = 0;
					String key = "test-" + this.getName();
					while (true) {
						try {
							Thread.sleep(1000);
							mJ.set(key, j++ + "");
							jedis.get(key);
						} catch (Exception e) {
							log.error("", e);;
						}
					}
				}
			}.start();
		}
	}
}
