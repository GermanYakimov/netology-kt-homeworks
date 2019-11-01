package ru.netology.germanyakimov.kotlin.ncraftmedia

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.germanyakimov.kotlin.dto.Event
import ru.netology.germanyakimov.kotlin.dto.x

class MainActivity : AppCompatActivity() {
    var post: Event = Event(
        id = 1,
        author = "Netology",
        content = "First post",
        created = "20 august 2019",
        likesCount = 0,
        commentsCount = 0,
        sharesCount = 0,
        likedByMe = false,
        commentedByMe = false,
        sharedByMe = false,
        address = "Россия, Москва, Красная площадь, 3",
        location = (55.754722).x(37.621389)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createdTv.text = post.created
        contentTv.text = post.content
        author.text = post.author

        likeBtn.setOnClickListener {
            post.likedByMe = !post.likedByMe
            if (it is Button) {
                it.setBackgroundResource(
                    if (post.likedByMe) R.drawable.ic_favorite_red_24dp
                    else R.drawable.ic_favorite_inactive_24dp
                )
            }

            if (post.likedByMe) post.likesCount += 1
            else post.likesCount -= 1

            updateLikesCount()
        }

        commentBtn.setOnClickListener {
            post.commentedByMe = !post.commentedByMe
            if (it is Button) {
                it.setBackgroundResource(
                    if (post.commentedByMe) R.drawable.ic_comment_red_24dp
                    else R.drawable.ic_comment_inactive_24dp
                )
            }

            if (post.commentedByMe) post.commentsCount += 1
            else post.commentsCount -= 1

            updateCommentsCount()
        }

        shareBtn.setOnClickListener{
            val intent= Intent().apply{
                action=Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,"""
                    ${post.author} (${post.created})
                    
                    ${post.content}
                """.trimIndent())
                type="text/plain"}
            startActivity(intent)

            post.sharedByMe = !post.sharedByMe
            if (it is Button) {
                it.setBackgroundResource(
                    if (post.sharedByMe) R.drawable.ic_share_red_24dp
                    else R.drawable.ic_share_inactive_24dp
                )
            }

            if (post.sharedByMe) post.sharesCount += 1
            else post.sharesCount -= 1

            updateSharesCount()
        }

        locationBtn.setOnClickListener {
            val intent= Intent().apply{
                action=Intent.ACTION_VIEW
                data= Uri.parse("geo:${post.location.lat},${post.location.lon}") }
            startActivity(intent)
        }

        updateLikesCount()
        updateCommentsCount()
        updateSharesCount()

        likeBtn.setBackgroundResource(
            if (post.likedByMe) R.drawable.ic_favorite_red_24dp
            else R.drawable.ic_favorite_inactive_24dp
        )

        commentBtn.setBackgroundResource(
            if (post.commentedByMe) R.drawable.ic_comment_red_24dp
            else R.drawable.ic_comment_inactive_24dp
        )

        shareBtn.setBackgroundResource(
            if (post.sharedByMe) R.drawable.ic_share_red_24dp
            else R.drawable.ic_share_inactive_24dp
        )

        locationBtn.setBackgroundResource(R.drawable.ic_place_black_24dp)
    }

    private fun updateLikesCount() {
        if (post.likesCount > 0) {
            likesCount.text = post.likesCount.toString()
            if (post.likedByMe) likesCount.setTextColor(Color.parseColor("#FF0000"))
            else likesCount.setTextColor(Color.parseColor("b3b3b3"))
        }
        else likesCount.text = ""
    }

    private fun updateCommentsCount() {
        if (post.commentsCount > 0) {
            commentsCount.text = post.commentsCount.toString()
            if (post.commentedByMe) commentsCount.setTextColor(Color.parseColor("#FF0000"))
            else commentsCount.setTextColor(Color.parseColor("b3b3b3"))
        }
        else commentsCount.text = ""
    }

    private fun updateSharesCount() {
        if (post.sharesCount > 0) {
            sharesCount.text = post.sharesCount.toString()
            if (post.sharedByMe) sharesCount.setTextColor(Color.parseColor("#FF0000"))
            else sharesCount.setTextColor(Color.parseColor("b3b3b3"))
        }
        else sharesCount.text = ""
    }
}
