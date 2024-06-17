package channel.com.Controller;

import channel.com.Entity.Channel;
import channel.com.Service.ChannelService;
import channel.com.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channels")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping
    public List<Channel> getAllChannels() {
        return channelService.getAllChannels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getChannelById(@PathVariable Long id) {
        Channel channel = channelService.getChannelById(id).orElseThrow(() -> new ResourceNotFoundException("Channel not found for this id :: " + id));
        return ResponseEntity.ok().body(channel);
    }

    @PostMapping
    public Channel createChannel(@RequestBody Channel channel) {
        return channelService.saveChannel(channel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateChannel(@PathVariable Long id, @RequestBody Channel channelDetails) {
        Channel updatedChannel = channelService.updateChannel(id, channelDetails);
        return ResponseEntity.ok(updatedChannel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChannel(@PathVariable Long id) {
        channelService.deleteChannel(id);
        return ResponseEntity.noContent().build();
    }
}
